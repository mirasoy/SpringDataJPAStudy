package com.example.demo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;

@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends Repository<T, ID> {
	
	<E extends T> E save(@NotNull E entity);
	
	List<T> findAll();
	
	@Nullable
	<E extends T> Optional<E> findById(ID id);
	
}
