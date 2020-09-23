package principles.lod.v1;

import principles.lod.Html;
import principles.lod.HtmlRequest;

public class HtmlDownloader {

    private NetworkTransporter transporter;//通过构造函数或IOC注入

    public Html downloadHtml(String url) {
        Byte[] rawHtml = transporter.send(new HtmlRequest(url));
        return new Html(rawHtml);
    }

}
