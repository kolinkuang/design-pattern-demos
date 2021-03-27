package principles.lod.sample1.v1;

import principles.lod.sample1.Html;
import principles.lod.sample1.HtmlRequest;

public class HtmlDownloader {

    private NetworkTransporter transporter;//通过构造函数或IOC注入

    public Html downloadHtml(String url) {
        Byte[] rawHtml = transporter.send(new HtmlRequest(url));
        return new Html(rawHtml);
    }

}
