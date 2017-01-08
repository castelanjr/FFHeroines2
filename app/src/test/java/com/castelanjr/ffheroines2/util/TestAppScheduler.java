package com.castelanjr.ffheroines2.util;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class TestAppScheduler implements AppScheduler {

    @Override
    public Scheduler io() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler mainThread() {
        return Schedulers.trampoline();
    }
}
