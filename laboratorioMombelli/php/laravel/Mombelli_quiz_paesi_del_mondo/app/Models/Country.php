<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Country extends Model
{
    protected $connection = 'domande_per_quiz';

    protected $table = 'countries';

    protected $primaryKey = 'alpha3Code';

    public $incrementing = false;

    protected $keyType = 'string';

    public $timestamps = false;

    protected $guarded = [];

    protected $casts = [
        'altSpellings' => 'array',
        'area' => 'array',
        'borders' => 'array',
        'callingCodes' => 'array',
        'currencies' => 'array',
        'gini' => 'array',
        'languages' => 'array',
        'latlng' => 'array',
        'regionalBlocs' => 'array',
        'timezones' => 'array',
        'topLevelDomain' => 'array',
        'translations' => 'array',
    ];

    public function getFlagUrlAttribute(): ?string
    {
        if (! $this->alpha2Code) {
            return null;
        }

        return 'https://flagcdn.com/' . strtolower($this->alpha2Code) . '.svg';
    }

    public function getLinguaPrincipaleAttribute(): ?string
    {
        return data_get($this->languages, '0.name')
            ?? data_get($this->languages, '0');
    }

    public function getValutaPrincipaleAttribute(): ?string
    {
        return data_get($this->currencies, '0.name')
            ?? data_get($this->currencies, '0.code')
            ?? data_get($this->currencies, '0');
    }
}