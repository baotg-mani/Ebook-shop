package com.cmcglobal.ebshop.service;

import com.cmcglobal.ebshop.dto.EbookDTO;

import java.util.List;

public interface EbookService {
    List<EbookDTO> getAllEbooks();

    EbookDTO getEbookById(long id);

    EbookDTO addEbook(EbookDTO ebookDTO);

    EbookDTO updateEbookById(EbookDTO ebookDTO, long id);

    void deleteEbookById(long id);
}
