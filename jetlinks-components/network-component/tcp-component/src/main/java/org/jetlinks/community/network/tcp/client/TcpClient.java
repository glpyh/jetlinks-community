package org.jetlinks.community.network.tcp.client;

import org.jetlinks.community.network.tcp.parser.PayloadParser;
import org.jetlinks.community.network.Network;
import org.jetlinks.community.network.tcp.TcpMessage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * TCP 客户端
 *
 * @author zhouhao
 * @version 1.0
 */
public interface TcpClient extends Network {

    /**
     * 获取客户端远程地址
     * @return 客户端远程地址
     */
    InetSocketAddress getRemoteAddress();

    /**
     * 订阅TCP消息,此消息是已经处理过粘拆包的完整消息
     *
     * @return TCP消息
     * @see PayloadParser
     */
    Flux<TcpMessage> subscribe();

    /**
     * 向客户端发送数据
     * @param message 数据对象
     * @return 发送结果
     */
    Mono<Boolean> send(TcpMessage message);

    /**
     *
     * @param listener
     */
    void onDisconnect(Runnable listener);

    /**
     * 连接保活
     */
    void keepAlive();

}
