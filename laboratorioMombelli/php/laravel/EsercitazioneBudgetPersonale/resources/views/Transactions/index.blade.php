@php
    $user = auth()->user();
@endphp

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Transactions</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body>
    <main class="container">
        <header class="grid">
            <div>
                <h1>Transactions</h1>
                <p>Manage your transactions.</p>
            </div>
            <nav>
                <a href="{{ route('transactions.create') }}" class="contrast">New transaction</a>
                <a href="{{ route('dashboard') }}">Dashboard</a>
            </nav>
        </header>

        @if(session('success'))
            <div class="notice">{{ session('success') }}</div>
        @endif

        @if($transactions->isEmpty())
            <p>No transactions yet.</p>
        @else
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Description</th>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Category</th>
                        <th>Receipt</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach($transactions as $transaction)
                        <tr>
                            <td>{{ $transaction->id }}</td>
                            <td>{{ $transaction->description }}</td>
                            <td>{{ $transaction->date->format('Y-m-d') }}</td>
                            <td>€{{ number_format($transaction->amount, 2) }}</td>
                            <td>{{ $transaction->category }}</td>
                            <td>
                                @if($transaction->receipt)
                                    <a href="{{ asset('storage/' . $transaction->receipt) }}" target="_blank">View</a>
                                @else
                                    —
                                @endif
                            </td>
                            <td>
                                <a href="{{ route('transactions.show', $transaction) }}">View</a>
                                <a href="{{ route('transactions.edit', $transaction) }}">Edit</a>

                                <form action="{{ route('transactions.destroy', $transaction) }}" method="POST" style="display:inline" onsubmit="return confirm('Delete this transaction?')">
                                    @csrf
                                    @method('DELETE')
                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    @endforeach
                </tbody>
            </table>
        @endif
    </main>
</body>
</html>