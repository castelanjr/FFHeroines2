package com.castelanjr.ffheroines2.util;

import io.reactivex.Scheduler;

public interface AppScheduler {
    Scheduler io();
    Scheduler mainThread();
}
