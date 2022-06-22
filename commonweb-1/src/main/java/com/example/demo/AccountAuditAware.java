package com.example.demo;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import com.example.demo.acaount.Account;


@Service
public class AccountAuditAware implements AuditorAware<Account> {

	@Override
	public Optional<Account> getCurrentAuditor() {
		
		System.err.println("_______AccountAuditAware_______");
		
		
		return null;
	}

}
