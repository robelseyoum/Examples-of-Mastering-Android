package com.robelseyoum3.journaler.database


/**
 * CRUD operations are operations for creating, updating, selecting, or removing data.
 * They are defined with an interface called Crud and it will be generic.
 * Create a new interface in the database package. Make sure it covers all CRUD operations:
 */
interface Crud<T> where T : DbModel {

    companion object {
        val BROADCASE_ACTION = "com.journaler.broadcast.crud"
        val BROADCASE_EXTRAS_KEY_CRUD_OPERATION_RESULT = "crud_result"
    }

    /**
     * Returns the ID of inserted item
     */
    fun insert(what: T): Long

    /**
     * Returns the list of inserted IDs
     */
    fun insert(what: Collection<T>): List<Long>

    /**
     * Returns the number of updated item
     */
    fun update(what: T): Int

    /**
     * Returns the number of updated items
     */
    fun update(what: Collection<T>): Int

    /**
     * Returns the number of deleted items
     */
    fun delete(what: T): Int


    /**
     * Returns the number of deleted items
     */
    fun delete(what: Collection<T>): Int

    /**
     * Returns the list of items
     */
    fun select(args: Pair<String, String>): List<T>

    /**
     * Returns the list of items
     */
    fun select(args: Collection<Pair<String, String>>): List<T>

    /**
     * Returns the list of items
     */
    fun selectAll(): List<T>
}