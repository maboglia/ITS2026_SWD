
<?php $__env->startSection('content'); ?>
    <h1>Lista dei Cinema</h1>
    <ul>
        <?php $__currentLoopData = $cinemas; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $cinema): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
            <li><?php echo e($cinema->nome_cinema); ?></li>
        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
    </ul>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.app', array_diff_key(get_defined_vars(), ['__data' => 1, '__path' => 1]))->render(); ?><?php /**PATH C:\Users\cristian.pappalardo\Documents\SWD_PHP\cinema\resources\views/cinema/index.blade.php ENDPATH**/ ?>