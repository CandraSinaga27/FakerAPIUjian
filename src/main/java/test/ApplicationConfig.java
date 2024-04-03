package test;

import org.aeonbits.owner.Config;


@Config.Sources({ "file:src/main/resources/config.properties" })
public interface ApplicationConfig extends Config{

//    @Config.Key("server.port")
//    int port();

    @Config.Key("server.base")
    String base();

    @Config.Key("server.base2")
    String base2();
    @Config.Key("server.host2")
    String host2();

    @Config.Key("server.base3")
    String base3();


    @Config.Key("server.host")
    String host();
    @Config.Key("server.base4")
    String base4();
    @Config.Key("server.host3")
    String host3();

    @Config.Key("server.base5")
    String base5();
    @Config.Key("server.host4")
    String host4();

    @Config.Key("server.base6")
    String base6();
    @Config.Key("server.host5")
    String host5();




}
