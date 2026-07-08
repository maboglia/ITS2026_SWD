<?php

namespace App\Http\Controllers;

use App\Models\Transaction;
use Illuminate\Http\Request;

class TransactionController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        // only show transactions for the authenticated user
        $user = auth()->user();
        if (!$user) {
            return redirect()->route('login');
        }

        $transactions = Transaction::where('user_id', $user->id)->orderBy('date', 'desc')->get();
        return view('transactions.index', compact('transactions'));
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('transactions.create');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {

        $validatedData = $request->validate([
            'description' => 'required|string|max:255',
            'date' => 'required|date',
            'amount' => 'required|numeric',
            'category' => 'required|in:Affitto,Stipendio,Spese Generali,Altro',
            'receipt' => 'nullable|file|mimes:jpg,jpeg,png,pdf|max:2048',
        ]);

        if ($request->hasFile('receipt')) {
            $validatedData['receipt'] = $request->file('receipt')->store('receipts', 'public');
        }

        // set the owner
        $validatedData['user_id'] = $request->user()->id;

        Transaction::create($validatedData);

        return redirect()->route('transactions.index')->with('success', 'Transaction created successfully.');
    }

    /**
     * Display the specified resource.
     */
    public function show(Transaction $transaction)
    {
        if ($transaction->user_id !== auth()->id()) {
            abort(403);
        }
        return view('transactions.show', compact('transaction'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Transaction $transaction)
    {
        if ($transaction->user_id !== auth()->id()) {
            abort(403);
        }
        return view('transactions.edit', compact('transaction'));
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Transaction $transaction)
    {
        $validatedData = $request->validate([
            'description' => 'required|string|max:255',
            'date' => 'required|date',
            'amount' => 'required|numeric',
            'category' => 'required|in:Affitto,Stipendio,Spese Generali,Altro',
            'receipt' => 'nullable|file|mimes:jpg,jpeg,png,pdf|max:2048',
        ]);

        if ($transaction->user_id !== auth()->id()) {
            abort(403);
        }

        if ($request->hasFile('receipt')) {
            $validatedData['receipt'] = $request->file('receipt')->store('receipts', 'public');
        }

        $transaction->update($validatedData);

        return redirect()->route('transactions.index')->with('success', 'Transaction updated successfully.');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Transaction $transaction)
    {
        if ($transaction->user_id !== auth()->id()) {
            abort(403);
        }

        $transaction->delete();

        return redirect()->route('transactions.index')->with('success', 'Transaction deleted successfully.');
    }
}
