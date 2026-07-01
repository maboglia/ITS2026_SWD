
<?php $__env->startSection('content'); ?>
    <h1>Lista delle Prenotazioni</h1>
    <ul>
        <?php $__currentLoopData = $prenotazioni; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $prenotazione): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
            <li><?php echo e($prenotazione->nome); ?> - Posti: <?php echo e($prenotazione->posti_prenotati); ?></li>
        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
    </ul>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.app', array_diff_key(get_defined_vars(), ['__data' => 1, '__path' => 1]))->render(); ?><?php /**PATH C:\Users\cristian.pappalardo\Documents\SWD_PHP\cinema\resources\views/prenotazioni/index.blade.php ENDPATH**/ ?>