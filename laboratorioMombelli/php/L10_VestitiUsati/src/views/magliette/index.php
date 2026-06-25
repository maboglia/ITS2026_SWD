<h1>Le nostre Magliette</h1>

<div class="magliette">
    <?php foreach ($magliette as $maglietta): ?>
        <div class="maglietta">
            <h2><?= $maglietta->nome ?></h2>
            <p>Descrizione: <?= $maglietta->descrizione ?></p>
            <p>Prezzo: €<?= number_format($maglietta->prezzo, 2) ?></p>
        </div>
    <?php endforeach; ?>
</div>