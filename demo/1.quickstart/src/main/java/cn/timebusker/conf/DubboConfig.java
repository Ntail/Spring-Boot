package cn.timebusker.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 2018-05-08
 *
 * 读取额外的配置文件的配置信息
 */
// @Configuration 标记一个类来作为bean定义的应用程序的上下文资源
@Configuration
// @PropertySource注解当前类，参数为对应的配置文件路径，这种方式加载配置文件
@PropertySource("classpath:dubbo.properties")
public class DubboConfig {

    @Value("{dubbo.resAddress}")
    private String resAddress;

    @Value("{dubbo.appName}")
    private String appName;

    @Value("{dubbo.resUsername}")
    private String resUsername;

    @Value("{dubbo.resPassword}")
    private String resPassword;

    @Value("{dubbo.protocol}")
    private String protocol;

    @Value("{dubbo.port}")
    private int port;

    @Value("{dubbo.accepts}")
    private int accepts;

    @Value("{dubbo.connections}")
    private int connections;

    @Override
    public String toString() {
        return "DubboConfig{" +
                "resAddress='" + resAddress + '\'' +
                ", appName='" + appName + '\'' +
                ", resUsername='" + resUsername + '\'' +
                ", resPassword='" + resPassword + '\'' +
                ", protocol='" + protocol + '\'' +
                ", port=" + port +
                ", accepts=" + accepts +
                ", connections=" + connections +
                '}';
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getResUsername() {
        return resUsername;
    }

    public void setResUsername(String resUsername) {
        this.resUsername = resUsername;
    }

    public String getResPassword() {
        return resPassword;
    }

    public void setResPassword(String resPassword) {
        this.resPassword = resPassword;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getAccepts() {
        return accepts;
    }

    public void setAccepts(int accepts) {
        this.accepts = accepts;
    }

    public int getConnections() {
        return connections;
    }

    public void setConnections(int connections) {
        this.connections = connections;
    }
}
