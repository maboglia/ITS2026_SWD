<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class CountriesSeeder extends Seeder
{
    private const SOURCE_URL = 'https://restcountries.com/v3.1/all?fields=cca2,cca3,altSpellings,area,borders,callingCodes,capital,currencies,demonym,flags,gini,languages,latlng,name,nativeName,numericCode,population,region,regionalBlocs,subregion,timezones,topLevelDomain,translations,cioc';

    public function run(): void
    {
        $payload = $this->downloadCountries();

        if ($payload === []) {
            $this->command?->warn('No country data downloaded.');

            return;
        }

        DB::connection('domande_per_quiz')
            ->table('countries')
            ->delete();

        foreach ($payload as $country) {
            DB::connection('domande_per_quiz')
                ->table('countries')
                ->insert([
                    'alpha2Code' => $country['cca2'] ?? null,
                    'alpha3Code' => $country['cca3'] ?? null,
                    'altSpellings' => $this->toJson($country['altSpellings'] ?? null),
                    'area' => $this->toJson($country['area'] ?? null),
                    'borders' => $this->toJson($country['borders'] ?? null),
                    'callingCodes' => $this->toJson($this->extractCallingCodes($country)),
                    'capital' => $this->extractFirstValue($country['capital'] ?? null),
                    'currencies' => $this->toJson($this->normalizeCurrencies($country['currencies'] ?? null)),
                    'demonym' => $country['demonym'] ?? null,
                    'flag' => data_get($country, 'flags.svg') ?? data_get($country, 'flags.png') ?? null,
                    'gini' => $this->toJson($country['gini'] ?? null),
                    'languages' => $this->toJson($this->normalizeLanguages($country['languages'] ?? null)),
                    'latlng' => $this->toJson($country['latlng'] ?? null),
                    'name' => data_get($country, 'name.common') ?? data_get($country, 'name') ?? null,
                    'nativeName' => data_get($country, 'name.official') ?? data_get($country, 'name.common') ?? null,
                    'numericCode' => $country['numericCode'] ?? null,
                    'population' => isset($country['population']) ? (string) $country['population'] : null,
                    'region' => $country['region'] ?? null,
                    'regionalBlocs' => $this->toJson($country['regionalBlocs'] ?? null),
                    'subregion' => $country['subregion'] ?? null,
                    'timezones' => $this->toJson($country['timezones'] ?? null),
                    'topLevelDomain' => $this->toJson($country['topLevelDomain'] ?? null),
                    'translations' => $this->toJson($country['translations'] ?? null),
                    'cioc' => $country['cioc'] ?? null,
                ]);
        }

        $this->command?->info('Imported ' . count($payload) . ' countries into domande_per_quiz.countries.');
    }

    private function downloadCountries(): array
    {
        $context = stream_context_create([
            'http' => [
                'timeout' => 30,
            ],
            'https' => [
                'timeout' => 30,
            ],
        ]);

        $response = @file_get_contents(self::SOURCE_URL, false, $context);

        if ($response === false) {
            return [];
        }

        $decoded = json_decode($response, true);

        return is_array($decoded) ? $decoded : [];
    }

    private function toJson(mixed $value): ?string
    {
        if ($value === null) {
            return null;
        }

        if (is_string($value)) {
            return json_encode([$value], JSON_UNESCAPED_UNICODE | JSON_UNESCAPED_SLASHES);
        }

        return json_encode($value, JSON_UNESCAPED_UNICODE | JSON_UNESCAPED_SLASHES);
    }

    private function extractFirstValue(mixed $value): ?string
    {
        if (is_array($value) && $value !== []) {
            $first = reset($value);

            return is_string($first) ? $first : json_encode($first, JSON_UNESCAPED_UNICODE | JSON_UNESCAPED_SLASHES);
        }

        return is_string($value) ? $value : null;
    }

    private function extractCallingCodes(array $country): ?array
    {
        if (isset($country['callingCodes']) && is_array($country['callingCodes'])) {
            return $country['callingCodes'];
        }

        if (isset($country['idd']['root']) && isset($country['idd']['suffixes']) && is_array($country['idd']['suffixes'])) {
            return array_map(
                static fn (string $suffix) => $country['idd']['root'] . $suffix,
                $country['idd']['suffixes']
            );
        }

        return null;
    }

    private function normalizeCurrencies(mixed $currencies): ?array
    {
        if (! is_array($currencies)) {
            return null;
        }

        $normalized = [];

        foreach ($currencies as $code => $currency) {
            $normalized[] = [
                'code' => $code,
                'name' => $currency['name'] ?? $code,
                'symbol' => $currency['symbol'] ?? null,
            ];
        }

        return $normalized;
    }

    private function normalizeLanguages(mixed $languages): ?array
    {
        if (! is_array($languages)) {
            return null;
        }

        $normalized = [];

        foreach ($languages as $code => $language) {
            $normalized[] = [
                'code' => $code,
                'name' => is_string($language) ? $language : (string) $language,
            ];
        }

        return $normalized;
    }
}