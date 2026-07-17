// Client-side helpers for Personal Budget Manager.
document.addEventListener('DOMContentLoaded', function () {
    // Auto-dismiss success alerts after 4 seconds.
    document.querySelectorAll('.alert-success').forEach(function (el) {
        setTimeout(function () {
            el.style.transition = 'opacity 0.5s';
            el.style.opacity = '0';
        }, 4000);
    });
});
