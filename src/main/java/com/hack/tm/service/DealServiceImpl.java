package com.hack.tm.service;

import com.hack.tm.domain.Store;
import com.hack.tm.repository.StoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DealServiceImpl implements DealService {

    private final StoreRepository storeRepository;

    @Override
    public List<Store> findTargetStore(String hname) throws Exception {
        return storeRepository.findByAddress_Hname(hname);

    }
}
