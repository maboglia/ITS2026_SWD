@extends('layouts.app')

@section('title')

@endsection

@section('content')

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Level</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($pokemon as $poke)
                    <tr>
                        <td>{{ $poke->id }}</td>
                        <td><a href="{{ route('pokemon.show', $poke) }}">{{ $poke->name }}</a></td>
                        <td><a href="{{ route('pokemon.type', ['type' => $poke->type]) }}">{{ $poke->type }}</a></td>
                        <td>{{ $poke->level }}</td>
                    </tr>
                @endforeach
            </tbody>
        </table>

@endsection
