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

        <h1>{{ $pokemon->Name }}</h1>
    
        <p><strong>ID:</strong> {{ $pokemon->id }}</p>
        <p><strong>Type:</strong> <a href="{{ route('pokemon.type', ['type' => $pokemon->{"Type 1"}]) }}">{{ $pokemon->{"Type 1"} }}</a></p>
        <p><strong>Total:</strong> {{ $pokemon->Total }}</p>
    
        <p><strong>Image:</strong></p>
        <img src="{{ $pokemon->imagine_url }}" alt="{{ $pokemon->Name }}">
    
        <p><strong>Image Large:</strong></p>
        <img src="{{ $pokemon->imagine_url_large }}" alt="{{ $pokemon->Name }}">
    
        @if ($pokemon->is_mega)
            <p><strong>Image Mega:</strong></p>
            <img src="{{ $pokemon->imagine_url_mega }}" alt="{{ $pokemon->Name }} Mega">
        @endif
    
        <a href="{{ route('pokemon.index') }}">Back to Pokedex</a>

    </div>
</body>
</html>

