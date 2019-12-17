package com.java4all.momo.connection;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IT云清
 */
public class ConnectionProxy implements Connection {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionProxy.class);

    /**Spring Connection*/
    private Connection connection;

    public ConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    /**
     * Makes all changes made since the previous
     * commit/rollback permanent and releases any database locks
     * currently held by this <code>Connection</code> object.
     * This method should be
     * used only when auto-commit mode has been disabled.
     *
     * @throws SQLException if a database access error occurs, this method is called while
     * participating in a distributed transaction, if this method is called on a closed connection
     * or this <code>Connection</code> object is in auto-commit mode
     * @see #setAutoCommit
     */
    @Override
    public void commit() throws SQLException {

        // wait TODO
        // 所有分支事务都无异常时，提交
        LOGGER.info("【momo】global transaction {} commit start......","全局事务id");
        connection.commit();
        LOGGER.info("【momo】global transaction {} commit end......","全局事务id");
    }

    /**
     * Undoes all changes made in the current transaction
     * and releases any database locks currently held
     * by this <code>Connection</code> object. This method should be
     * used only when auto-commit mode has been disabled.
     *
     * @throws SQLException if a database access error occurs, this method is called while
     * participating in a distributed transaction, this method is called on a closed connection or
     * this <code>Connection</code> object is in auto-commit mode
     * @see #setAutoCommit
     */
    @Override
    public void rollback() throws SQLException {

        //wait TODO
        //如果有任何分支事务出现异常
        LOGGER.info("【momo】global transaction {} rollback start......","全局事务id");
        connection.rollback();
        //TODO 回滚异常时的重试机制
        LOGGER.info("【momo】global transaction {} rollback end......","全局事务id");
    }


    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }


    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return connection.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return connection.nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return connection.getAutoCommit();
    }

    /**
     * Releases this <code>Connection</code> object's database and JDBC resources
     * immediately instead of waiting for them to be automatically released.
     * <P>
     * Calling the method <code>close</code> on a <code>Connection</code>
     * object that is already closed is a no-op.
     * <P>
     * It is <b>strongly recommended</b> that an application explicitly
     * commits or rolls back an active transaction prior to calling the
     * <code>close</code> method.  If the <code>close</code> method is called
     * and there is an active transaction, the results are implementation-defined.
     * <P>
     *
     * @throws SQLException SQLException if a database access error occurs
     */
    @Override
    public void close() throws SQLException {
        connection.close();
    }

    /**
     * Retrieves whether this <code>Connection</code> object has been
     * closed.  A connection is closed if the method <code>close</code>
     * has been called on it or if certain fatal errors have occurred.
     * This method is guaranteed to return <code>true</code> only when
     * it is called after the method <code>Connection.close</code> has
     * been called.
     * <P>
     * This method generally cannot be called to determine whether a
     * connection to a database is valid or invalid.  A typical client
     * can determine that a connection is invalid by catching any
     * exceptions that might be thrown when an operation is attempted.
     *
     * @return <code>true</code> if this <code>Connection</code> object is closed;
     * <code>false</code> if it is still open
     * @throws SQLException if a database access error occurs
     */
    @Override
    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }

    /**
     * Retrieves a <code>DatabaseMetaData</code> object that contains
     * metadata about the database to which this
     * <code>Connection</code> object represents a connection.
     * The metadata includes information about the database's
     * tables, its supported SQL grammar, its stored
     * procedures, the capabilities of this connection, and so on.
     *
     * @return a <code>DatabaseMetaData</code> object for this <code>Connection</code> object
     * @throws SQLException if a database access error occurs or this method is called on a closed
     * connection
     */
    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return connection.getMetaData();
    }

    /**
     * Puts this connection in read-only mode as a hint to the driver to enable
     * database optimizations.
     *
     * <P><B>Note:</B> This method cannot be called during a transaction.
     *
     * @param readOnly <code>true</code> enables read-only mode; <code>false</code> disables it
     * @throws SQLException if a database access error occurs, this method is called on a closed
     * connection or this method is called during a transaction
     */
    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        connection.setReadOnly(readOnly);
    }

    /**
     * Retrieves whether this <code>Connection</code>
     * object is in read-only mode.
     *
     * @return <code>true</code> if this <code>Connection</code> object is read-only;
     * <code>false</code> otherwise
     * @throws SQLException SQLException if a database access error occurs or this method is called
     * on a closed connection
     */
    @Override
    public boolean isReadOnly() throws SQLException {
        return connection.isReadOnly();
    }

    /**
     * Sets the given catalog name in order to select
     * a subspace of this <code>Connection</code> object's database
     * in which to work.
     * <P>
     * If the driver does not support catalogs, it will
     * silently ignore this request.
     * <p>
     * Calling {@code setCatalog} has no effect on previously created or prepared
     * {@code Statement} objects. It is implementation defined whether a DBMS
     * prepare operation takes place immediately when the {@code Connection}
     * method {@code prepareStatement} or {@code prepareCall} is invoked.
     * For maximum portability, {@code setCatalog} should be called before a
     * {@code Statement} is created or prepared.
     *
     * @param catalog the name of a catalog (subspace in this <code>Connection</code> object's
     * database) in which to work
     * @throws SQLException if a database access error occurs or this method is called on a closed
     * connection
     * @see #getCatalog
     */
    @Override
    public void setCatalog(String catalog) throws SQLException {
        connection.setCatalog(catalog);
    }

    /**
     * Retrieves this <code>Connection</code> object's current catalog name.
     *
     * @return the current catalog name or <code>null</code> if there is none
     * @throws SQLException if a database access error occurs or this method is called on a closed
     * connection
     * @see #setCatalog
     */
    @Override
    public String getCatalog() throws SQLException {
        return connection.getCatalog();
    }

    /**
     * Attempts to change the transaction isolation level for this
     * <code>Connection</code> object to the one given.
     * The constants defined in the interface <code>Connection</code>
     * are the possible transaction isolation levels.
     * <P>
     * <B>Note:</B> If this method is called during a transaction, the result
     * is implementation-defined.
     *
     * @param level one of the following <code>Connection</code> constants:
     * <code>Connection.TRANSACTION_READ_UNCOMMITTED</code>, <code>Connection.TRANSACTION_READ_COMMITTED</code>,
     * <code>Connection.TRANSACTION_REPEATABLE_READ</code>, or <code>Connection.TRANSACTION_SERIALIZABLE</code>.
     * (Note that <code>Connection.TRANSACTION_NONE</code> cannot be used because it specifies that
     * transactions are not supported.)
     * @throws SQLException if a database access error occurs, this method is called on a closed
     * connection or the given parameter is not one of the <code>Connection</code> constants
     * @see DatabaseMetaData#supportsTransactionIsolationLevel
     * @see #getTransactionIsolation
     */
    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        connection.setTransactionIsolation(level);
    }

    /**
     * Retrieves this <code>Connection</code> object's current
     * transaction isolation level.
     *
     * @return the current transaction isolation level, which will be one of the following
     * constants: <code>Connection.TRANSACTION_READ_UNCOMMITTED</code>,
     * <code>Connection.TRANSACTION_READ_COMMITTED</code>, <code>Connection.TRANSACTION_REPEATABLE_READ</code>,
     * <code>Connection.TRANSACTION_SERIALIZABLE</code>, or <code>Connection.TRANSACTION_NONE</code>.
     * @throws SQLException if a database access error occurs or this method is called on a closed
     * connection
     * @see #setTransactionIsolation
     */
    @Override
    public int getTransactionIsolation() throws SQLException {
        return connection.getTransactionIsolation();
    }


    @Override
    public SQLWarning getWarnings() throws SQLException {
        return connection.getWarnings();
    }


    @Override
    public void clearWarnings() throws SQLException {
        connection.clearWarnings();
    }


    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency)
            throws SQLException {
        return connection.createStatement(resultSetType,resultSetConcurrency);
    }


    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType,
            int resultSetConcurrency) throws SQLException {
        return connection.prepareCall(sql,resultSetType,resultSetConcurrency);
    }


    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
            throws SQLException {
        return connection.prepareCall(sql,resultSetType,resultSetConcurrency);
    }


    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return connection.getTypeMap();
    }


    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        connection.setTypeMap(map);
    }


    @Override
    public void setHoldability(int holdability) throws SQLException {
        connection.setHoldability(holdability);
    }


    @Override
    public int getHoldability() throws SQLException {
        return connection.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return connection.setSavepoint();
    }


    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return connection.setSavepoint(name);
    }

    /**
     * Undoes all changes made after the given <code>Savepoint</code> object
     * was set.
     * <P>
     * This method should be used only when auto-commit has been disabled.
     *
     * @param savepoint the <code>Savepoint</code> object to roll back to
     * @throws SQLException if a database access error occurs, this method is called while
     * participating in a distributed transaction, this method is called on a closed connection, the
     * <code>Savepoint</code> object is no longer valid, or this <code>Connection</code> object is
     * currently in auto-commit mode
     * @see Savepoint
     * @see #rollback
     * @since 1.4
     */
    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        connection.rollback(savepoint);
    }


    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        connection.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException {
        return connection.createStatement(resultSetType,resultSetConcurrency,resultSetHoldability);
    }


    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType,
            int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.prepareStatement(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }


    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException {
        return connection.prepareCall(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }


    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
            throws SQLException {
        return connection.prepareStatement(sql,autoGeneratedKeys);
    }


    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return connection.prepareStatement(sql,columnIndexes);
    }


    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames)
            throws SQLException {
        return connection.prepareStatement(sql,columnNames);
    }


    @Override
    public Clob createClob() throws SQLException {
        return connection.createClob();
    }


    @Override
    public Blob createBlob() throws SQLException {
        return connection.createBlob();
    }


    @Override
    public NClob createNClob() throws SQLException {
        return connection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return connection.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return connection.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        connection.setClientInfo(name,value);
    }


    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        connection.setClientInfo(properties);
    }


    @Override
    public String getClientInfo(String name) throws SQLException {
        return connection.getClientInfo(name);
    }


    @Override
    public Properties getClientInfo() throws SQLException {
        return connection.getClientInfo();
    }


    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return connection.createArrayOf(typeName,elements);
    }


    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return connection.createStruct(typeName,attributes);
    }


    @Override
    public void setSchema(String schema) throws SQLException {
        connection.setSchema(schema);
    }


    @Override
    public String getSchema() throws SQLException {
        return connection.getSchema();
    }

    /**
     * Terminates an open connection.  Calling <code>abort</code> results in:
     * <ul>
     * <li>The connection marked as closed
     * <li>Closes any physical connection to the database
     * <li>Releases resources used by the connection
     * <li>Insures that any thread that is currently accessing the connection
     * will either progress to completion or throw an <code>SQLException</code>.
     * </ul>
     * <p>
     * Calling <code>abort</code> marks the connection closed and releases any
     * resources. Calling <code>abort</code> on a closed connection is a
     * no-op.
     * <p>
     * It is possible that the aborting and releasing of the resources that are
     * held by the connection can take an extended period of time.  When the
     * <code>abort</code> method returns, the connection will have been marked as
     * closed and the <code>Executor</code> that was passed as a parameter to abort
     * may still be executing tasks to release resources.
     * <p>
     * This method checks to see that there is an <code>SQLPermission</code>
     * object before allowing the method to proceed.  If a
     * <code>SecurityManager</code> exists and its
     * <code>checkPermission</code> method denies calling <code>abort</code>,
     * this method throws a
     * <code>java.lang.SecurityException</code>.
     *
     * @param executor The <code>Executor</code>  implementation which will be used by
     * <code>abort</code>.
     * @throws SQLException if a database access error occurs or the {@code executor} is {@code
     * null},
     * @throws SecurityException if a security manager exists and its <code>checkPermission</code>
     * method denies calling <code>abort</code>
     * @see SecurityManager#checkPermission
     * @see Executor
     * @since 1.7
     */
    @Override
    public void abort(Executor executor) throws SQLException {
        connection.abort(executor);
    }

    /**
     * Sets the maximum period a <code>Connection</code> or
     * objects created from the <code>Connection</code>
     * will wait for the database to reply to any one request. If any
     * request remains unanswered, the waiting method will
     * return with a <code>SQLException</code>, and the <code>Connection</code>
     * or objects created from the <code>Connection</code>  will be marked as
     * closed. Any subsequent use of
     * the objects, with the exception of the <code>close</code>,
     * <code>isClosed</code> or <code>Connection.isValid</code>
     * methods, will result in  a <code>SQLException</code>.
     * <p>
     * <b>Note</b>: This method is intended to address a rare but serious
     * condition where network partitions can cause threads issuing JDBC calls
     * to hang uninterruptedly in socket reads, until the OS TCP-TIMEOUT
     * (typically 10 minutes). This method is related to the
     * {@link #abort abort() } method which provides an administrator
     * thread a means to free any such threads in cases where the
     * JDBC connection is accessible to the administrator thread.
     * The <code>setNetworkTimeout</code> method will cover cases where
     * there is no administrator thread, or it has no access to the
     * connection. This method is severe in it's effects, and should be
     * given a high enough value so it is never triggered before any more
     * normal timeouts, such as transaction timeouts.
     * <p>
     * JDBC driver implementations  may also choose to support the
     * {@code setNetworkTimeout} method to impose a limit on database
     * response time, in environments where no network is present.
     * <p>
     * Drivers may internally implement some or all of their API calls with
     * multiple internal driver-database transmissions, and it is left to the
     * driver implementation to determine whether the limit will be
     * applied always to the response to the API call, or to any
     * single  request made during the API call.
     * <p>
     *
     * This method can be invoked more than once, such as to set a limit for an
     * area of JDBC code, and to reset to the default on exit from this area.
     * Invocation of this method has no impact on already outstanding
     * requests.
     * <p>
     * The {@code Statement.setQueryTimeout()} timeout value is independent of the
     * timeout value specified in {@code setNetworkTimeout}. If the query timeout
     * expires  before the network timeout then the
     * statement execution will be canceled. If the network is still
     * active the result will be that both the statement and connection
     * are still usable. However if the network timeout expires before
     * the query timeout or if the statement timeout fails due to network
     * problems, the connection will be marked as closed, any resources held by
     * the connection will be released and both the connection and
     * statement will be unusable.
     * <p>
     * When the driver determines that the {@code setNetworkTimeout} timeout
     * value has expired, the JDBC driver marks the connection
     * closed and releases any resources held by the connection.
     * <p>
     *
     * This method checks to see that there is an <code>SQLPermission</code>
     * object before allowing the method to proceed.  If a
     * <code>SecurityManager</code> exists and its
     * <code>checkPermission</code> method denies calling
     * <code>setNetworkTimeout</code>, this method throws a
     * <code>java.lang.SecurityException</code>.
     *
     * @param executor The <code>Executor</code>  implementation which will be used by
     * <code>setNetworkTimeout</code>.
     * @param milliseconds The time in milliseconds to wait for the database operation to complete.
     * If the JDBC driver does not support milliseconds, the JDBC driver will round the value up to
     * the nearest second.  If the timeout period expires before the operation completes, a
     * SQLException will be thrown. A value of 0 indicates that there is not timeout for database
     * operations.
     * @throws SQLException if a database access error occurs, this method is called on a closed
     * connection, the {@code executor} is {@code null}, or the value specified for
     * <code>seconds</code> is less than 0.
     * @throws SecurityException if a security manager exists and its <code>checkPermission</code>
     * method denies calling <code>setNetworkTimeout</code>.
     * @see SecurityManager#checkPermission
     * @see Statement#setQueryTimeout
     * @see #getNetworkTimeout
     * @see #abort
     * @see Executor
     * @since 1.7
     */
    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        connection.setNetworkTimeout(executor,milliseconds);
    }


    @Override
    public int getNetworkTimeout() throws SQLException {
        return connection.getNetworkTimeout();
    }


    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return connection.unwrap(iface);
    }


    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return connection.isWrapperFor(iface);
    }
}
