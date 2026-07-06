@extends('layouts.app')

@section('title')
        <h2>{{ $pokemon->name }}</h2>
@endsection

@section('content')

        <p>Type: {{ $pokemon->type }}</p>
        <p>Level: {{ $pokemon->level }}</p>
        <p>Image: <img src="{{ $pokemon->image_url }}" alt="{{ $pokemon->name }}"></p>
        <p>Large Image: <img src="{{ $pokemon->large_image_url }}" alt="{{ $pokemon->name }}"></p>

        <button onclick="history.back()">Back to All Pokémon</button>

@endsection

