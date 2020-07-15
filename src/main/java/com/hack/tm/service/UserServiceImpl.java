package com.hack.tm.service;

import com.hack.tm.domain.Address;
import com.hack.tm.domain.User;
import com.hack.tm.repository.AddressRepository;
import com.hack.tm.repository.UserRepository;
import com.hack.tm.vo.DaumMapAddrParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    public User findByUser(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new DataFormatException("사용자 정보를 찾을 수 없습니다."));
    }

    @Override
    public Address getUserAddress(User user) {
        return user.getAddr();
    }

    @Override
    public Address insertUserAddress(Long id, DaumMapAddrParam param) throws Exception {
        User user = this.findByUser(id);
        user.updateAddr(createAddressEntitiy(param));
        User updateUser = userRepository.save(user);

        return updateUser.getAddr();
    }

    private Address createAddressEntitiy(DaumMapAddrParam param) {
        return Address.builder()
                .address(param.getAddress())
                .zonecode(param.getZonecode())
                .addressEnglish(param.getAddressEnglish())
                .bname(param.getBname())
                .sido(param.getSido())
                .sigungu(param.getSigungu())
                .sigungucode(param.getSigunguCode())
                .buildName(param.getBuildName())
                .hname(param.getBname())
                .roadName(param.getRoadName())
                .jibunAddress(param.getJibunAddress())
                .detailAddress(param.getJibunAddress())
                .build();
    }


}
