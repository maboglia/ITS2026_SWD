@php
    $user = auth()->user();
    use App\Models\Transaction;
    if ($user) {
        $transactionsCount = Transaction::where('user_id', $user->id)->count();
        $balance = Transaction::where('user_id', $user->id)->sum('amount');
    } else {
        $transactionsCount = 0;
        $balance = 0;
    }
@endphp

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body>
    <main class="container">
        <header class="grid">
            <div>
                <hgroup>
                    <h1>Dashboard</h1>
                    <h2>Welcome back{{ $user ? ' — ' . $user->name : '' }}</h2>
                </hgroup>
            </div>
            <nav>
                @auth
                    <form method="POST" action="{{ route('logout') }}">
                        @csrf
                        <button type="submit">Logout</button>
                    </form>
                @else
                    <a href="{{ route('login') }}">Login</a>
                @endauth
            </nav>
        </header>

        <section>
            <article>
                <h3>Overview</h3>
                <p>Quick summary of your account.</p>
                <p><a class="contrast" href="{{ route('transactions.index') }}">View Transactions</a></p>
                <div class="grid">
                    <div>
                        <strong>Balance</strong>
                        <p>€{{ number_format($balance, 2) }}</p>
                    </div>
                    <div>
                        <strong>Transactions</strong>
                        <p><a href="{{ route('transactions.index') }}">{{ $transactionsCount }}</a></p>
                </div>
            </article>

            <article>
                <h3>Account</h3>
                @if($user)
                    <ul>
                        <li><strong>Name:</strong> {{ $user->name }}</li>
                        <li><strong>Email:</strong> {{ $user->email }}</li>
                    </ul>
                @else
                    <p>No user information available.</p>
                @endif
            </article>
<!--
            <article>
                <h3>API</h3>
                <p>Session-based API endpoints:</p>
                <ul>
                    <li>POST <code>/api/register</code></li>
                    <li>POST <code>/api/login</code></li>
                    <li>GET <code>/api/user</code> (requires session)</li>
                    <li>POST <code>/api/logout</code></li>
                </ul>
            </article>
-->
        </section>
    </main>
</body>
</html>