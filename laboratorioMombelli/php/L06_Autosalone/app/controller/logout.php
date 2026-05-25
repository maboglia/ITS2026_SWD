<?php

function logout() {
    if($_SESSION['logged_in'] ?? false) {
        unset($_SESSION['logged_in']);
        unset($_SESSION['username']);

        session_destroy();
    }
}