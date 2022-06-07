package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.types.Predicate;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void crud() {
		QAccount account= QAccount.account; 
		Predicate predicate = account
				.firstName.containsIgnoreCase("MR")
				.and(account.lastName.startsWith("K"));
		
		Optional<Account> list =  accountRepository.findOne(predicate);
		
		assertThat(list).isEmpty();
	}
}

