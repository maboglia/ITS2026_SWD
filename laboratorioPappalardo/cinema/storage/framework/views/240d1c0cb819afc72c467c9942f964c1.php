
<?php $__env->startSection('content'); ?>
    <h1>Lista dei Film in Sala</h1>
    <ul>
        <?php $__currentLoopData = $filmInSalas; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $filmInSala): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
            <li><?php echo e($filmInSala->posti_rimanenti); ?></li>
        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
    </ul>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.app', array_diff_key(get_defined_vars(), ['__data' => 1, '__path' => 1]))->render(); ?><?php /**PATH C:\Users\cristian.pappalardo\Documents\SWD_PHP\cinema\resources\views/film_in_sala/index.blade.php ENDPATH**/ ?>