@extends('layouts.app')

@section('title')

@endsection

@section('content')

        <table class="table">
            <thead>
                <tr>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($types as $type)
                    <tr>
                        <td><a href="{{ route('pokemon.type', ['type' => $type]) }}">{{ $type }}</a></td>
                    </tr>
                @endforeach
            </tbody>
        </table>

@endsection
