class CoursesController < ApplicationController
  def index
  	@search_term = params[:looking_for] || 'java'
  	@courses  = Coursera.for(@search_term)
  	@courses ||= []
  end
end
