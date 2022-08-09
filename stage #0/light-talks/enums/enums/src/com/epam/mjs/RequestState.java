package com.epam.mjs;

public enum RequestState {

    CREATED{
        @Override
        public RequestState nextState() {
            return SUBMITTED;
        }
    }, SUBMITTED{
        @Override
        public RequestState nextState() {
            return APPROVED;
        }

    }, APPROVED{
        @Override
        public RequestState nextState() {
            return APPROVED;
        }

    };

    public abstract RequestState nextState();
}
