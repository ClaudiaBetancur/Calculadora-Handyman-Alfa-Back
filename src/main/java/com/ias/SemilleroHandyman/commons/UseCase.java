package com.ias.SemilleroHandyman.commons;

public interface UseCase<Input, Output> {
    Output excute(Input input);
}
