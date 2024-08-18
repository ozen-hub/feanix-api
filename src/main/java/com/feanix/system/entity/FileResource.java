package com.feanix.system.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

import java.sql.Blob;

@Embeddable
public class FileResource {
    @Lob
    private Blob fileName;
    @Lob
    private Blob resourceUrl;
    @Lob
    private Blob directory;
    @Lob
    private Blob hash;
}
