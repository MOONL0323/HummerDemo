package com.ahua.myRPC_00.client;

import com.ahua.myRPC_00.common.User;
import com.ahua.myRPC_00.server.UserServiceImpl;
import com.ahua.myRPC_00.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author AAAAAAQQQQQ
 */
public class RPCClient {
    public static void main(String[] args){
        try{
            Socket socket=new Socket("localhost",8899);

            //读取并输出用户ID
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Integer userId = Integer.parseInt(reader.readLine());

            ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(userId);

            //获取返回结果
            ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
            User user=(User) input.readObject();

            System.out.println("响应！");
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
