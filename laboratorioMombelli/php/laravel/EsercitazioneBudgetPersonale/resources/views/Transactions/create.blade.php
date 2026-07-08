@php $user = auth()->user(); @endphp

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Transaction</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
    <style>
        .form-grid { max-width: 720px; margin: 0 auto; }
        .actions { display:flex; gap:8px; align-items:center; }
    </style>
</head>
<body>
    <main class="container">
        <header class="grid">
            <div>
                <h1>New Transaction</h1>
                <p>Create a new transaction for your account.</p>
            </div>
            <nav>
                @auth
                    <a href="{{ route('dashboard') }}">Dashboard</a>
                @endauth
            </nav>
        </header>

        @if(session('success'))
            <section>
                <div class="toast success">{{ session('success') }}</div>
            </section>
        @endif

        @if($errors->any())
            <section>
                <strong>There were some problems with your submission:</strong>
                <ul>
                    @foreach($errors->all() as $error)
                        <li>{{ $error }}</li>
                    @endforeach
                </ul>
            </section>
        @endif

        <section class="form-grid">
            <form method="POST" action="{{ route('transactions.store') }}" enctype="multipart/form-data">
                @csrf

                <label for="description">Description</label>
                <textarea id="description" name="description" rows="3">{{ old('description') }}</textarea>

                <label for="date">Date</label>
                <input type="date" id="date" name="date" value="{{ old('date', now()->toDateString()) }}">

                <label for="amount">Amount (€)</label>
                <input type="number" step="0.01" id="amount" name="amount" value="{{ old('amount') }}" required>

                <label for="category">Category</label>
                @php $categories = ['Affitto','Stipendio','Spese Generali','Altro']; @endphp
                <select id="category" name="category">
                    @foreach($categories as $cat)
                        <option value="{{ $cat }}" {{ old('category') == $cat ? 'selected' : '' }}>{{ $cat }}</option>
                    @endforeach
                </select>
                <form action="upload.php" method="POST" enctype="multipart/form-data">
                    <label for="receipt">Receipt (optional)</label>
                    <input type="file" id="receipt" name="receipt" accept="image/*,application/pdf">
                    <button type="submit">Upload</button>
                </form>

                <div class="actions">
                    <button type="submit" class="contrast">Create Transaction</button>
                    <a href="{{ route('transactions.index') }}">Cancel</a>
                </div>
            </form>
        </section>
    </main>
    <script>
        (function () {
            const form = document.querySelector('form');
            form.addEventListener('submit', function (e) {
                const errors = [];
                const description = document.getElementById('description').value.trim();
                const date = document.getElementById('date').value;
                const amount = parseFloat(document.getElementById('amount').value);

                if (!description) errors.push('Description is required.');
                if (!date) errors.push('Date is required.');
                if (Number.isNaN(amount)) {
                    errors.push('Amount must be a number.');
                } else if (amount === 0) {
                    errors.push('Amount cannot be zero.');
                }

                if (errors.length) {
                    e.preventDefault();
                    alert(errors.join('\n'));
                    return false;
                }
            });
        })();
    </script>
</body>
</html>