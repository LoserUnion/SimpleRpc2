package com.wk.simplerpc.client;

import com.wk.simplerpc.common.RpcRequest;
import com.wk.simplerpc.common.RpcResponse;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * PackageName com.wk.simplerpc.client
 * Created by wangkang on 2017/11/13.
 */
public class RpcProxy {
    private String serverAddress;
    private ServiceDiscovery serviceDiscovery;

    public RpcProxy(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public RpcProxy(ServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    @SuppressWarnings("unchecked")
    public <T> T create(Class<?> interfaceClass) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        RpcRequest request = new RpcRequest(); // 创建并初始化 RPC 请求
                        request.setRequestId(UUID.randomUUID().toString());
                        request.setClassName(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParameters(args);
                        System.out.println("wk-->request: \n threadid:" +
                                Thread.currentThread().getId() + "\n"+ request);
                        if (serviceDiscovery != null) {
                            serverAddress = serviceDiscovery.discover(); // 发现服务
                        }

                        String[] array = serverAddress.split(":");
                        String host = array[0];
                        int port = Integer.parseInt(array[1]);

                        RpcClient client = new RpcClient(host, port); // 初始化 RPC 客户端
                        RpcResponse response = client.send(request); // 通过 RPC 客户端发送 RPC 请求并获取 RPC 响应

                        if (response.getError() != null) {
                            throw response.getError();
                        } else {
                            return response.getResult();
                        }
                    }
                }
        );
    }
}
