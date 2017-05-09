Rails.application.routes.draw do

  resources :books do
  	resources :notes, only: [:create, :destroy]  	
  end

  resources :sessions, only: [:new, :create, :destroy]

  root to: "books#index" 

  get "/login" => "sessions#new", as: "login"
  delete "/logout" => "sessions#destroy", as: "logout"
end
