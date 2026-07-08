<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Transaction;
use Illuminate\Http\Request;
use Illuminate\Http\JsonResponse;

class TransactionController extends Controller
{
    /**
     * Display a listing of the resource for the authenticated user.
     */
    public function index(Request $request): JsonResponse
    {
        $user = $request->user();
        $transactions = Transaction::where('user_id', $user->id)->orderBy('date', 'desc')->get();

        $transactions->transform(function ($t) {
            $t->receipt_url = $t->receipt ? asset('storage/' . $t->receipt) : null;
            return $t;
        });

        return response()->json(['data' => $transactions], 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request): JsonResponse
    {
        $user = $request->user();

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

        $validatedData['user_id'] = $user->id;

        $transaction = Transaction::create($validatedData);
        $transaction->receipt_url = $transaction->receipt ? asset('storage/' . $transaction->receipt) : null;

        return response()->json(['data' => $transaction], 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(Request $request, Transaction $transaction): JsonResponse
    {
        if ($transaction->user_id !== $request->user()->id) {
            return response()->json(['message' => 'Forbidden'], 403);
        }

        $transaction->receipt_url = $transaction->receipt ? asset('storage/' . $transaction->receipt) : null;
        return response()->json(['data' => $transaction], 200);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Transaction $transaction): JsonResponse
    {
        if ($transaction->user_id !== $request->user()->id) {
            return response()->json(['message' => 'Forbidden'], 403);
        }

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

        $transaction->update($validatedData);
        $transaction->receipt_url = $transaction->receipt ? asset('storage/' . $transaction->receipt) : null;

        return response()->json(['data' => $transaction], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Request $request, Transaction $transaction): JsonResponse
    {
        if ($transaction->user_id !== $request->user()->id) {
            return response()->json(['message' => 'Forbidden'], 403);
        }

        $transaction->delete();

        return response()->json(null, 204);
    }
}
