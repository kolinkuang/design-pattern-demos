package principles.lod.sample1.v1;

import principles.lod.sample1.Html;

public class Document {

    private Html html;
    private String url;

    public Document(String url) {
        this.url = url;
        HtmlDownloader downloader = new HtmlDownloader();
        this.html = downloader.downloadHtml(url);
    }

}
