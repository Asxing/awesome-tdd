package com.holddie;

public interface TransactionManager {

	<T> T doInTransaction(TransactionCode<T> code);

}
