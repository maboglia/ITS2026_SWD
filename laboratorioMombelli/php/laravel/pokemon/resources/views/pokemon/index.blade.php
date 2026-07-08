<!doctype html>
<html lang="en">
<head>
    <!-- Document head start: metadata, title, and linked resources -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="01-print-reverse">
    <meta name="author" content="Maikol">
    <title>Title</title>

    <!-- Open Graph metadata used by social platforms when the page is shared -->
    <!--
    <meta property="og:title" content="Title">
    <meta property="og:type" content="Type">
    <meta property="og:url" content="URL">
    <meta property="og:description" content="Description of the content">
    <meta property="og:image" content="Image">
    -->
    <!--
    <link rel="icon" href="favicon.ico">
    -->
    <!-- Favicon displayed in the browser tab -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
    <!-- Link to external CSS stylesheet for page styling -->

    <script defer src="./scripts/main.js"></script> <!-- Defer loading of main JavaScript until after HTML parsing -->
    <!-- End of the head section -->
</head>
<body>
     <div class="container">

        <h1>Pokedex</h1>

        <nav>
            <a href="{{ route('pokemon.index') }}" @if (!isset($type) || $type === null || $type === '') aria-current="page" @endif>All</a>
            <!--
            @foreach ($types as $pokemonType)
                <a href="{{ route('pokemon.type', ['type' => $pokemonType]) }}" @if ($type === $pokemonType) aria-current="page" @endif>{{ $pokemonType }}</a>
            @endforeach
-->
        </nav>

        @if (isset($type) && $type !== null && $type !== '')
            <p>Showing only {{ $type }} type Pokémon.</p>
        @endif

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($pokemon as $poke)
                    <tr>
                        <td>{{ $poke->id }}</td>
                        <td><a href="{{ route('pokemon.show', $poke) }}">{{ $poke->Name }}</a></td>
                        <td>
                            @if ($poke->{"Type 1"})
                                <a href="{{ route('pokemon.type', ['type' => $poke->{"Type 1"}]) }}">{{ $poke->{"Type 1"} }}</a>
                            @else
                                -
                            @endif
                        </td>
                        <td>{{ $poke->Total }}</td>
                    </tr>
                @endforeach
            </tbody>
        </table>


    </div>
</body>
</html>
