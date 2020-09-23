package principles.lod.v2;

import principles.lod.Html;

public class Document {

    private Html html;
    private String url;

    public Document(String url, Html html) {
        this.html = html;
        this.url = url;
    }

}
