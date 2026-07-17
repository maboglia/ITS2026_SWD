<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="quiz-paesi-del-mondo">
    <meta name="author" content="Maikol">
    <title>@yield('title', 'Quiz Paesi del Mondo')</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body>
    <main class="container">
        @if (session('messaggio'))
            <article>
                {{ session('messaggio') }}
            </article>
        @endif

        @yield('content')
    </main>
</body>
</html>