package com.hack.tm.service;

import com.hack.tm.domain.Store;
import java.util.List;

public interface DealService {

    List<Store> findTargetStore(String hname) throws Exception;
}
