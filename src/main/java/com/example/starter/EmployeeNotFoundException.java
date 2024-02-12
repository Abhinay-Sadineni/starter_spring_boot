package com.example.starter;
class EmployeeNotFoundException extends RuntimeException {

        EmployeeNotFoundException(Long id) {
            super("Could not find employee " + id);
        }

}

