package principles.lod.sample1.v2;

import principles.lod.sample1.Html;
import principles.lod.sample1.HtmlRequest;

public class HtmlDownloader {

    private NetworkTransporter transporter;//通过构造函数或IOC注入

    // HtmlDownloader这里也要有相应的修改
    public Html downloadHtml(String url) {
        HtmlRequest htmlRequest = new HtmlRequest(url);
        Byte[] rawHtml = transporter.send(
                htmlRequest.getAddress(), htmlRequest.getContent().getBytes());
        return new Html(rawHtml);
    }

}
