
        <h1><?= $titolo ?></h1>
        <table>
            <thead>
                <tr>
                    <th>Marca</th>
                    <th>Modello</th>
                    <th>Cilindrata</th>
                    <th>Prezzo</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($automobili as $automobile): ?>
                    <tr>
                        <td><?= $automobile->marca ?></td>
                        <td><?= $automobile->modello ?></td>
                        <td><?= $automobile->cilindrata ?></td>
                        <td><?= $automobile->prezzo ?></td>
                    </tr>
                <?php endforeach; ?>