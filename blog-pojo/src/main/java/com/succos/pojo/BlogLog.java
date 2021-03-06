package com.succos.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "blog_log")
public class BlogLog {
    /**
     * 日志id
     */
    @Id
    @Column(name = "log_id")
    private Integer logId;

    /**
     * 请求路径
     */
    @Column(name = "log_url")
    private String logUrl;

    /**
     * 参数
     */
    @Column(name = "log_params")
    private String logParams;

    /**
     * 访问状态，1正常0异常
     */
    @Column(name = "log_status")
    private Integer logStatus;

    /**
     * 请求方式，get、post等
     */
    @Column(name = "log_method")
    private String logMethod;

    /**
     * 响应时间
     */
    @Column(name = "log_time")
    private Long logTime;

    /**
     * 请求ip
     */
    @Column(name = "log_ip")
    private String logIp;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * 异常信息
     */
    @Column(name = "log_message")
    private String logMessage;

    /**
     * 返回值
     */
    @Column(name = "log_result")
    private String logResult;

    /**
     * 获取日志id
     *
     * @return log_id - 日志id
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 设置日志id
     *
     * @param logId 日志id
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 获取请求路径
     *
     * @return log_url - 请求路径
     */
    public String getLogUrl() {
        return logUrl;
    }

    /**
     * 设置请求路径
     *
     * @param logUrl 请求路径
     */
    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    /**
     * 获取参数
     *
     * @return log_params - 参数
     */
    public String getLogParams() {
        return logParams;
    }

    /**
     * 设置参数
     *
     * @param logParams 参数
     */
    public void setLogParams(String logParams) {
        this.logParams = logParams;
    }

    /**
     * 获取访问状态，1正常0异常
     *
     * @return log_status - 访问状态，1正常0异常
     */
    public Integer getLogStatus() {
        return logStatus;
    }

    /**
     * 设置访问状态，1正常0异常
     *
     * @param logStatus 访问状态，1正常0异常
     */
    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    /**
     * 获取请求方式，get、post等
     *
     * @return log_method - 请求方式，get、post等
     */
    public String getLogMethod() {
        return logMethod;
    }

    /**
     * 设置请求方式，get、post等
     *
     * @param logMethod 请求方式，get、post等
     */
    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    /**
     * 获取响应时间
     *
     * @return log_time - 响应时间
     */
    public Long getLogTime() {
        return logTime;
    }

    /**
     * 设置响应时间
     *
     * @param logTime 响应时间
     */
    public void setLogTime(Long logTime) {
        this.logTime = logTime;
    }

    /**
     * 获取请求ip
     *
     * @return log_ip - 请求ip
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     * 设置请求ip
     *
     * @param logIp 请求ip
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取异常信息
     *
     * @return log_message - 异常信息
     */
    public String getLogMessage() {
        return logMessage;
    }

    /**
     * 设置异常信息
     *
     * @param logMessage 异常信息
     */
    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    /**
     * 获取返回值
     *
     * @return log_result - 返回值
     */
    public String getLogResult() {
        return logResult;
    }

    /**
     * 设置返回值
     *
     * @param logResult 返回值
     */
    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }
}