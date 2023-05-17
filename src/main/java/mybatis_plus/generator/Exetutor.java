package mybatis_plus.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import java.util.Collections;

public class Exetutor {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://39.105.160.181:3306/hut_server?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false", "root", "password")
                .globalConfig(builder -> {
                    builder.author("HandleX") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D://code//java//HutServer//src//main//java"); // 指定输出目录
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER, TemplateType.SERVICE, TemplateType.SERVICE_IMPL);
                })
                .packageConfig(builder -> {
                    builder.parent("com.hut") // 设置父包名
                            .moduleName("hutserver") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://code//java//HutServer//src//main//resources//mapping")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    // hut_users,hut_user_relationship,hut_posts,hut_post_comments,hut_post_likes,hut_post_collection,hut_brow_history,hut_notifications,hut_chat_message,hut_group_message,hut_chat_group_info,hut_group_member
                    builder.addInclude("hut_user_relationship")
                            .entityBuilder()
                            .enableFileOverride()
                            .disableSerialVersionUID()
                            .formatFileName("%sEntity")
                            .addTableFills(new Column("created_at", FieldFill.INSERT))
                            .addTableFills(new Property("updated_at", FieldFill.INSERT_UPDATE))
                            .mapperBuilder()
                            .enableFileOverride();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
