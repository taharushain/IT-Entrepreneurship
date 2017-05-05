Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  resources :books do
  	resources :notes, only: [:create, :destroy]  	
  end


  root to: "books#index" 

end
