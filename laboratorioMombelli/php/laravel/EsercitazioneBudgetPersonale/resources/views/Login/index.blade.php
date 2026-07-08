@php $old = old(); @endphp

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body>
    <main class="container">
        <article>
            <h1>Login</h1>

            @if($errors->any())
                <div class="notice -warning">
                    <ul>
                        @foreach($errors->all() as $error)
                            <li>{{ $error }}</li>
                        @endforeach
                    </ul>
                </div>
            @endif

            <form method="POST" action="{{ route('login.authenticate') }}">
                @csrf

                <label for="email">Email</label>
                <input id="email" name="email" type="email" value="{{ old('email') }}" required autofocus>

                <label for="password">Password</label>
                <input id="password" name="password" type="password" required>
<!--
                <label for="remember">
                    <input id="remember" name="remember" type="checkbox" {{ old('remember') ? 'checked' : '' }}>
                    Remember me
                </label>
-->
                <div>
                    <button type="submit">Sign in</button>
                    @if (Route::has('register'))
                        <a href="{{ route('register') }}">Register</a>
                    @endif
                </div>
            </form>
        </article>
    </main>
</body>
</html>