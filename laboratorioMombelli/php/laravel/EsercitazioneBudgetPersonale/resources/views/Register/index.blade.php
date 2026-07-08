@php $old = old(); @endphp

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body>
    <main class="container">
        <article>
            <h1>Register</h1>

            @if($errors->any())
                <div class="notice -warning">
                    <ul>
                        @foreach($errors->all() as $error)
                            <li>{{ $error }}</li>
                        @endforeach
                    </ul>
                </div>
            @endif

            <form method="POST" action="{{ route('register.store') }}">
                @csrf

                <label for="name">Name</label>
                <input id="name" name="name" type="text" value="{{ old('name') }}" required autofocus>

                <label for="email">Email</label>
                <input id="email" name="email" type="email" value="{{ old('email') }}" required>

                <label for="password">Password</label>
                <input id="password" name="password" type="password" required>

                <label for="password_confirmation">Confirm Password</label>
                <input id="password_confirmation" name="password_confirmation" type="password" required>

                <div>
                    <button type="submit">Create account</button>
                    <a href="{{ route('login') }}">Already have an account?</a>
                </div>
            </form>
        </article>
    </main>
</body>
</html>