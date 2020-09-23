package principles.lod.v2;

import principles.lod.Html;

// 通过一个工厂方法来创建Document
public class DocumentFactory {

    private final HtmlDownloader downloader;

    public DocumentFactory(HtmlDownloader downloader) {
        this.downloader = downloader;
    }

    public Document createDocument(String url) {
        Html html = downloader.downloadHtml(url);
        return new Document(url, html);
    }

}
