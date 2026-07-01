<html>
<head>
    <title>My App</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
    <title>@yield('title')</title>
</head>
<body>

    @include('layout.app.php')

    <div class="container">
        @yield('content')

    </div>
</body>
</html>